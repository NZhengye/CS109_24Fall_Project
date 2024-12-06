package model;

import java.io.File;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class User implements Serializable {

    public static User currentUser;
    private String uid;
    private String password;
    private int key;

    private boolean isNoGuest = true;

    static Random random = new Random();

    public User(String uid, String password, boolean isNoGuest) {
        this.uid = uid;
        this.password = password;

        if (isNoGuest) {
            this.key = randomKey(password);
            this.password = encode(password);

            //保存当前用户信息
            try {
                this.save();
            } catch (IOException ignore) {
                //todo:
            }

            //更新用户列表
            File info = new File("account\\accounts.ser");
            try (FileInputStream fileInputStream = new FileInputStream(info);
                 ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
                ArrayList<String> users = (ArrayList<String>) ois.readObject();
                users.add(this.uid);
                ois.close();

                ObjectOutputStream oos = null;
                FileOutputStream fileOutputStream = new FileOutputStream(info);
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(users);
                oos.close();
            } catch (IOException | ClassNotFoundException e) {
                try {
                    ArrayList<String> users = new ArrayList<>();
                    users.add(this.uid);
                    ObjectOutputStream oos;
                    FileOutputStream fileOutputStream;
                    fileOutputStream = new FileOutputStream(info);
                    oos = new ObjectOutputStream(fileOutputStream);
                    oos.writeObject(users);
                    oos.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }

    private int randomKey(String password) {
        int k;
        while (true) {
            k = random.nextInt(-password.length(), password.length());
            if (Math.abs(k) >= password.length() / 3)
                return k;
        }
    }

    private String encode(String plain) {
        StringBuilder cypher = new StringBuilder();
        int p = this.key;
        for (int i = 0; i < plain.length(); i++) {
            cypher.append((char) (plain.charAt(i) + p));
            p = p - 1 == 0 ? key : p - 1;
        }
        return cypher.reverse().toString();
    }

    private String decode(String cypher, int key) {
        StringBuilder plain = new StringBuilder();
        int p = key;
        for (int i = cypher.length() - 1; i >= 0; i--) {
            plain.append((char) (cypher.charAt(i) - p));
            p = p - 1 == 0 ? key : p - 1;
        }
        return plain.toString();
    }

    public void save() throws IOException {
        //System.out.println(System.getProperty("user.dir"));
        //新建用户目录
        File accountPath = new File("account\\" + uid);
        accountPath.mkdirs();

        //把用户信息存下
        File info = new File("account\\" + uid + "\\info.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(info);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(this);
        oos.close();
    }

    //todo: 用用户list来判断账户情况
    public static int checkAccount(String uid, String password) {
        if (uid.isEmpty()) return -1;
        File info = new File("account\\" + uid + "\\info.ser");
        if (!info.exists()) {
            return 0;//账号不存在
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(info);
                 ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
                User user = (User) ois.readObject();
                if (user.decode(user.password, user.key).equals(password)) {
                    currentUser = user;
                    return 3;//密码正确
                } else {
                    return 2;//密码错误
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return 1;//文件损毁
            }
        }
    }

    public static void load(String uid, String password) throws IOException, ClassNotFoundException {
        File info = new File("account\\" + uid + "\\info.ser");
        if (!info.exists()) {
            throw new FileNotFoundException("User data not found for UID: " + uid);
        }
        try (FileInputStream fileInputStream = new FileInputStream(info);
             ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
            User user = (User) ois.readObject();
            if (user.decode(user.password, user.key).equals(password)) {
                System.out.println(("OK"));
            } else {
                System.out.println("no");
            }
            currentUser = user;
        } catch (IOException e) {
            System.out.println("文件损毁");
        }
    }
}
