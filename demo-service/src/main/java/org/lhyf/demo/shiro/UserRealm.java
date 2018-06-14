package org.lhyf.demo.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.lhyf.demo.pojo.TUser;
import org.lhyf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/****
 * @author YF
 * @date 2018-06-12 14:55
 * @desc UserRealm
 *
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        TUser user = userService.selectByName(username);

        if(user==null){
            throw new UnknownAccountException("用户不存在!");
        }

        if("offline".equals(user.getStatus())){
            throw new LockedAccountException("用户账号被锁定");
        }

        ByteSource source = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,user.getPassword(),source,getName());

        return info;
    }


    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456","tom",1024);
        System.out.println(md5Hash.toString());
    }
}
