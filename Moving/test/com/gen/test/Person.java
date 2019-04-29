package com.gen.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Table("person")
public class Person {
    @Column("name")
    private String name;
    @Column("user_name")
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public static String query(Person person){
        StringBuilder sb = new StringBuilder();
        Class p = person.getClass();
        boolean exist = p.isAnnotationPresent(Table.class);
        if (!exist){
            return null;
        }
        Table table = (Table) p.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from").append(tableName).append("where 1 = 1");
        Field[] fArrary = p.getDeclaredFields();
        for (Field field :
                fArrary) {
            boolean fExist = field.isAnnotationPresent(Column.class);
            if (!fExist){
                return null;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            String fieldName = field.getName();
            Object fieldValue = null;
            String getMethodName = "get" + fieldName.substring(0,1).toUpperCase()
                    +fieldName.substring(1);

            try {
                Method method = p.getMethod(getMethodName);
                fieldValue = method.invoke(person);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            sb.append("and").append(columnName).append("*").append(fieldValue);

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("牛逼大佬");
        p1.setUsername("User也是牛逼大佬");
        String str = query(p1);
        System.out.println(str);
    }
}
