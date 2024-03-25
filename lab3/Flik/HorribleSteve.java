public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {//该方法是比较i和j的地址的
                //存在自动装箱，传参时调用底层Integer.valueOf方法,
                // 底层有一个Inte数组装着-128~127范围的数，范围内则直接返回数组里的一个Integer
                // 超出范围则会重新new一个Integer返回，当i和j到128时，地址就已经不同了
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
