package com.xxt.listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xxt.entity.User;
import com.xxt.utils.SessionUtil;
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	//����� number��������ͳ��
    private int number;
	@Override
	//����
	public void sessionCreated(HttpSessionEvent arg0) {
		number++;
		//�����û��������洢�������ServletContext��number��
		arg0.getSession().getServletContext().setAttribute("number", number);
		}

	@Override
	//����
	public void sessionDestroyed(HttpSessionEvent arg0) {
		number--;
		arg0.getSession().getServletContext().setAttribute("number", number);
		//list�Ǵ洢�������ServletContext�У����ڼ�¼�û��ĵ���־��Ϣ
		ArrayList<User> list=
				(ArrayList<User>) arg0.getSession().getServletContext().getAttribute("userList");
		//����sessionidɾ����Ҫ�Ƴ����û���Ϣ
		SessionUtil.remove(list,arg0.getSession().getId());
		arg0.getSession().getServletContext().setAttribute("userList", list);
	}

}
