package com.boots.framework.listener;


import com.boots.framework.bean.base.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginSessionListener
 * Description:
 * Date: 2016/4/23 10:22
 *
 * @author jj18534
 * @version V1.0
 */
public class LoginSessionListener implements HttpSessionAttributeListener {
    Map<String, HttpSession> map = new HashMap<>();// ��¼����Щ�û�

    // ��¼
    public void attributeAdded(HttpSessionBindingEvent event) {// session������һ��keyʱ�ᴥ��
        if (!(event.getValue() instanceof User)) {
            return;
        }

        add(event, (User) event.getValue());
    }

    // ע��
    public void attributeRemoved(HttpSessionBindingEvent event) {// session��ɾ��һ��keyʱ�ᴥ��
        if (!(event.getValue() instanceof User)) {
            return;
        }
        User user = (User) event.getValue();// ���ر�ɾ���ĵ�user
        if (user != null) {
            map.remove(user.getJobNumber());
        }
    }

    // û��ע��������£�����һ���ʺŵ�¼
    public void attributeReplaced(HttpSessionBindingEvent event) {// session���滻һ��keyʱ�ᴥ��
        if (!(event.getValue() instanceof User)) {
            return;
        }

        // �Ƴ��ɵĵĵ�¼��Ϣ
        User oldUser = (User) event.getValue();// ���ر��滻�ĵ�user
        if (oldUser != null) {
            map.remove(oldUser.getJobNumber());
        }

        // �����µĵ�¼��Ϣ
        User user = (User) event.getSession().getAttribute(User.ATTRIBUTE);
        add(event, user);
    }

    private void add(HttpSessionBindingEvent event, User user) {
        String key = user.getJobNumber();
        if (map.get(key) != null) {// map���м�¼���������ʺ������������ϵ�¼��
            HttpSession session = map.get(key);
            session.removeAttribute(User.ATTRIBUTE);// ����ǰ�ĵ�¼ʧЧ
        } else {
            map.put(key, event.getSession());
        }
    }

}
