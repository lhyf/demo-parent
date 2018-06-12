package org.lhyf.demo.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/****
 * @author YF
 * @date 2018-06-12 15:29
 * @desc CustomSessionManager
 *
 **/
public class CustomSessionManager extends DefaultWebSessionManager {

    private static Logger logger = LoggerFactory.getLogger(CustomSessionManager.class);

    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;
        if (sessionKey instanceof WebSessionKey) {
            request = ((WebSessionKey) sessionKey).getServletRequest();
        }

        if (request != null && sessionId != null) {
            Session session = (Session) request.getAttribute(sessionId.toString());
            if(session != null){
                logger.debug("从request获取sesion1");
                return session;
            }
        }
        Session session = super.retrieveSession(sessionKey);
        logger.debug("从Redis获取sesion");
        if (request != null && sessionId != null) {
            request.setAttribute(sessionId.toString(), session);
        }

        return session;
    }
}
