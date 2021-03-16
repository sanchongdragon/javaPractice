package hiberPractice;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataBase {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();

		cfg = cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			// 儲存單字
			HiberBook word = new HiberBook("apple","蘋果");
			HiberBook word1 = new HiberBook("banana","香蕉");
			session.save(word);
			session.save(word1);

			
			int sid = word.getId();
			int sid2 = word1.getId();

			HiberBook show = new HiberBook();
			HiberBook show1 = new HiberBook();

			show = (HiberBook) session.get(HiberBook.class, sid);
			show1 = (HiberBook) session.get(HiberBook.class, sid2);

			System.out.printf("第一個英文單字:%s的中文:%s\n",word.getenName(),word.getchName());
			System.out.printf("第二個英文單字:%s的中文:%s\n",word1.getenName(),word1.getchName());
			
			trans.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("儲存失敗");
			session.close();
		}

	}
}
