package com.sy.myweber.conf;


import com.sy.myweber.entity.SysRole;
import com.sy.myweber.entity.SysSource;
import com.sy.myweber.entity.SysUser;
import com.sy.myweber.service.SysRoleService;
import com.sy.myweber.service.SysSourceService;
import com.sy.myweber.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author supersuger
 * @date 2020/08/06
 */
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysSourceService sysSourceService;

    /**
     * 授权
     * @param principalCollection 身份集合
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser= (SysUser) principalCollection.getPrimaryPrincipal();
        List<SysRole> roles=sysRoleService.getRolesByUserId(sysUser.getId());
        List<SysSource> menus=sysSourceService.getMenusByUserId(sysUser.getId());
        simpleAuthorizationInfo.addRoles(roles.stream().map(SysRole::getRoleName).collect(Collectors.toSet()));
        simpleAuthorizationInfo.addStringPermissions(menus.stream().map(SysSource::getSourcePerms).collect(Collectors.toSet()));
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username= (String) authenticationToken.getPrincipal();
        SysUser sysUser  = new SysUser();
        sysUser.setName(username);
        SysUser userCheck =sysUserService.selectByUser(sysUser);
        if(userCheck == null){
            throw new UnknownAccountException("用户名或密码错误");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                userCheck,userCheck.getPwd(), ByteSource.Util.bytes(userCheck.getSalt()),getName()
        );
        Session session=SecurityUtils.getSubject().getSession();
        session.setAttribute("sysUser",userCheck);
        return simpleAuthenticationInfo;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}