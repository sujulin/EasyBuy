package cn.easybuy.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyTool {
	public static <T> List<T> tool(ResultSet rs, Class<T> cls) {
		try {
			List<T> list = new ArrayList<T>();
			// ����ѯ���������ת��Ϊ������ӵ�����
			while (rs.next()) {
				// ʵ�����
				T obj = cls.newInstance();
				// ��ȡ�������е�����
				Field[] fid = cls.getDeclaredFields();
				// ��������
				for (Field f : fid) {
					// ���ÿ��Է���˽���ֶ�
					f.setAccessible(true);
					// Ϊ������������
					f.set(obj, rs.getObject(f.getName()));
				}
				list.add(obj);// ��ӵ�����
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
