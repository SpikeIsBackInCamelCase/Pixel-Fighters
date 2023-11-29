public class NumCalc {

        
        public static double rdm() {
            return Math.random() * 10000;
        }
    
        public static int rounded() {
            return (int) (.5 + (Math.random() * 10));
        }
    
        public static int bin() {
            return Math.random() < 0.5 ? 0 : 1;
        }
}
