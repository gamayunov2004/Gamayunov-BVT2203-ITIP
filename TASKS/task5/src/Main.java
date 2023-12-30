import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("----Задание 1----");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println(sameLetterPattern("ABABA", "BCBC"));
        System.out.println("----Задание 2---");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(spiderVsFly("H4", "A3"));//муха ближе, направление обратное
        System.out.println(spiderVsFly("G4", "A3"));//муха ближе, ещё одно обратное
        System.out.println(spiderVsFly("A3", "H3"));//шаг назад через граничный случай
        System.out.println(spiderVsFly("A3", "G3"));//два шага назад через граничный случай
        System.out.println(spiderVsFly("E2", "C4"));//ОШИБКА
        System.out.println("----Задание 3----");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println("----Задание 4----");
        String words1[] = {"cat","create", "sat"};
        String words2[] = {"trance", "recant"};
        String words3[] = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(words1, "caster"));
        System.out.println(totalPoints(words2, "recant"));
        System.out.println(totalPoints(words3, "tossed"));
        System.out.println("----Задание 5----");
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 7, 9};
        int[] nums3 = {10, 9, 7, 2, 8};
        int[] nums4 = {1, 6, 5, 4, 8, 2, 3, 7};
        System.out.println(Arrays.deepToString(sumsUp(nums1).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(nums2).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(nums3).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(nums4).toArray()));
        System.out.println("---Задание6----");
        String[] str1 = {"95%", "83%", "90%", "87%", "88%", "91%"};
        String[] str2 = {"10%"};
        String[] str3 = {"53%", "79%"};
        System.out.println(takeDownAverage(str1));
        System.out.println(takeDownAverage(str2));
        System.out.println(takeDownAverage(str3));
        System.out.println("---Задание7----");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println("---Задание8----");
        System.out.println(setSetup(5,3));
        System.out.println(setSetup(7,3));
        System.out.println("---Задание9----");
        System.out.println(timeDifference("Moscow", "April 1, 2011 03:40", "New York" ));
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 00:23", "Canberra")); //ситуация, когда по времени плюс, но ничего в дате не меняется
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 22:23", "Canberra")); //новый день
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); //новый месяц 31
        System.out.println(timeDifference("London", "June 30, 1983 23:01", "Rome")); // переход на новый месяц при 30 днях
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); //новый год
        System.out.println(timeDifference("London", "February 29, 2000 23:40", "Rome")); //новый високосный месяц
        System.out.println("---Задание10----");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(130));
    }
    public static boolean sameLetterPattern(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        for(int i = 0; i < a.length() - 1; i++){
            if((a.charAt(i) - a.charAt(i+1)) != (b.charAt(i) - b.charAt(i+1))){
                return false;
            }
        }
        return true;
    }
    public static String spiderVsFly(String start, String end){
        String ans = "";
        int num_start = Integer.parseInt(String.valueOf(start.charAt(1)));
        int num_end = Integer.parseInt(String.valueOf(end.charAt(1)));
        int sum_center = num_start + num_end;
        //дуги
        int cnt_ring = Math.abs(start.charAt(0) - end.charAt(0));
        if(cnt_ring > 4){
            cnt_ring = 8 - cnt_ring;
        }
        int best_ring = Math.min(num_end, num_start);
        double len_ring = Math.sqrt((best_ring*best_ring*2 - 2*best_ring*best_ring * (Math.sqrt(2)/2)));
        double sum_ring = cnt_ring * len_ring + Math.abs(num_start - num_end);
        //центр
        if(sum_center < sum_ring){
            for(int i=num_start; i > 0; i--){
                ans += start.charAt(0) + String.valueOf(i)+ "-";
            }
            ans += "A0-";
            for(int i=1; i < num_end; i ++){
                ans += end.charAt(0) + String.valueOf(i) + "-";
            }
        }
        //дуги

        //ищем напрвление
        char cur1 = 'A';// по часовой стрелке будем считать
        char cur2 = 'A'; // против часовой

        for(int i = 1; i <= cnt_ring; i++){
            cur1 = (char) ((start.charAt(0) - 'A' +i)%8 + 'A');
            cur2= (char) ((8-start.charAt(0) -i + 'A')%8 + 'A');
        }

        //если паук находится на большой дуге по длине, он сначала спускается вниз
        if(sum_ring < sum_center && num_start > num_end){
            for(int i= num_start; i > num_end-1; i--){
                ans += start.charAt(0) + String.valueOf(i)+ "-";
            }
            //ищем ответ, если идем против часовой стрелки
            if(cur2 == end.charAt(0)){
                for(int i =1; i < cnt_ring; i++){
                    char new_letter = (char) ((8-start.charAt(0) -i + 'A')%8 + 'A');;
                    ans += String.valueOf(new_letter) + end.charAt(1)+"-";
                }}
            //ищем ответ, если идем по часовой стрелке
            else{
                for(int i=1; i < cnt_ring; i++){
                    char new_letter = (char) ((start.charAt(0) - 'A' +i)%8 + 'A');
                    ans += String.valueOf(new_letter) + end.charAt(1)+"-";
                }
            }
        }
        //если паук находится на меньшей дуге по длине, он сначала идет по дугам, а потом подниамается
        if(sum_ring < sum_center && num_start <= num_end){
            ans += start + "-";
            //ищем ответ, если идем против часовой стрелки
            if(cur2 == end.charAt(0)){
                for(int i=1; i < cnt_ring; i++){
                    char new_letter = (char) ((8-start.charAt(0) -i + 'A')%8 + 'A');
                    ans += String.valueOf(new_letter) + start.charAt(1)+"-";
                }
            }
            //ищем ответ, если идем по часовой стрелке
            else{
                for(int i=1; i < cnt_ring; i++){
                    char new_letter = (char) ((start.charAt(0) - 'A' +i)%8 + 'A');
                    ans += String.valueOf(new_letter) + start.charAt(1)+"-";
                }
            }
            if(num_start == num_end){
                return ans += end;
            }
            else{
                for(int i = num_start; i < num_end; i++){
                    ans += end.charAt(0) + String.valueOf(i)+ "-";
                }
            }
        }
        return ans += end;
    }
    public static int digitsCount(long a){
        if(a < 10){
            return 1;
        }
        else{
            a /= 10;
            return 1 + digitsCount(a);
        }
    }
    public static int totalPoints(String[] words, String scrambleWord){
        int points = 0;
        for (int i=0; i<words.length; i++){ // iteration by words
            String tempWord = words[i];
            for (int j=0; j<scrambleWord.length(); j++){ //iteration by letters in scrambled word
                char currentLetter = scrambleWord.charAt(j);
                for (int k=0; k<count(currentLetter, scrambleWord); k++){
                    tempWord = tempWord.replaceFirst(""+currentLetter, ""); //deletion equale latters
                }
                if (tempWord.length()==0){
                    if (words[i].length()!=scrambleWord.length()){
                        points += words[i].length()-2;
                    }
                    else{
                        points += 54;
                    }
                    break;
                }
            }
        }
        return points;
    }

    public static int count(char letter, String word){
        return word.length() - word.replace(String.valueOf(letter), "").length();
    }

    public static ArrayList<int[]> sumsUp(int[] a){
        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<Integer> gap = new ArrayList<>();
        ArrayList<Integer> exclusion = new ArrayList<>();
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] + a[j] == 8 && !exclusion.contains(j)){
                    gap.add(Math.abs(j - i));
                    exclusion.add(j);
                    result.add(new int[]{Math.min(a[i], a[j]), Math.max(a[i], a[j])});
                }
            }
        }
        for(int i = 0; i < gap.size(); i++) {
            for (int j = i + 1; j < gap.size(); j++) {
                if(gap.get(i) > gap.get(j)){
                    int b = gap.get(i);
                    gap.set(i, gap.get(j));
                    gap.set(j, b);
                    int[] c = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, c);
                }
            }
        }
        return result;
    }
    public static String takeDownAverage(String[] interest){
        int sum1 = 0;
        for(int i=0; i < interest.length;i++ ){
            sum1 += Integer.parseInt(interest[i].replaceAll("%",""));
        }
        return (int)((interest.length+1)*(sum1/interest.length - 5)- sum1) + "%";
    }
    public static String caesarCipher(String code, String str, int shift){
        String ans = "";
        str = str.toUpperCase();
        String[] words = str.split(" ");
        if(code == "encode"){
            for(int i = 0; i < words.length; i++){
                for(int j=0; j< words[i].length(); j++){
                    if('A' < words[i].charAt(j) && 'Z' > words[i].charAt(j)){
                        ans += (char) ((words[i].charAt(j)+shift - 'A')%26 + 'A');
                    }
                    else{
                        ans += words[i].charAt(j);
                    }
                }
                ans += " ";
            }
        }
        else{
            for(int i = 0; i < words.length; i++){
                for(int j=0; j< words[i].length(); j++){
                    if('A' < words[i].charAt(j) && 'Z' > words[i].charAt(j)){
                        ans += (char) ((words[i].charAt(j)+(26-shift) - 'A')%26 + 'A');
                    }
                    else{
                        ans += words[i].charAt(j);
                    }
                }
                ans += " ";
            }
        }
        return ans.trim();
    }
    public static int setSetup(int n, int k){
        if (n<k){return 0;}
        if (k==0){
            return 1;
        }
        else{
            return n*setSetup(n-1, k-1);
        }
    }
    public static String timeDifference(String cityA, String dateTime, String cityB){
        //хешмап для городов и их поясов
        HashMap<String, Double> cityTime = new HashMap<String, Double>();
        cityTime.put("Los Angeles", -8.);
        cityTime.put("New York", -5.);
        cityTime.put("Caracas", -4.5);
        cityTime.put("Buenos Aires", -3.);
        cityTime.put("London", 0.);
        cityTime.put("Rome", 1.);
        cityTime.put("Moscow", 3.);
        cityTime.put("Tehran", 3.5);
        cityTime.put("New Delhi", 5.5);
        cityTime.put("Beijing", 8.);
        cityTime.put("Canberra", 10.);

        //хешмап для месяцев и их номеров
        HashMap<String, Integer> monthes = new HashMap<String, Integer>();
        monthes.put("January", 0);
        monthes.put("February", 1);
        monthes.put("March", 2);
        monthes.put("April", 3);
        monthes.put("May", 4);
        monthes.put("June", 5);
        monthes.put("July", 6);
        monthes.put("Augest", 7);
        monthes.put("September", 8);
        monthes.put("October", 9);
        monthes.put("November", 10);
        monthes.put("December", 11);

        //слова для месяцев с количеством дней 31
        int[] day31 = {-1,0,2,4,6,7,9,11};


        //парсинг месяца, дня, года, часа и минут в заданном городе
        int month = monthes.get(dateTime.split(",")[0].split(" ")[0]);
        int day = Integer.parseInt(dateTime.split(",")[0].split(" ")[1]);
        int year = Integer.parseInt(dateTime.split(", ")[1].split(" ")[0]);
        double hour = Integer.parseInt(dateTime.split(", ")[1].split(" ")[1].split(":")[0]);
        int minutes = Integer.parseInt(dateTime.split(", ")[1].split(" ")[1].split(":")[1]);

        //нахождение количества часов, которое будет в другом городе
        hour = hour - cityTime.get(cityA) + cityTime.get(cityB);

        double allMinutes = minutes + hour * 60;

        //случай наступления нового дня
        if (allMinutes>=24*60){
            allMinutes -= 24*60; //новый час
            day+=1; //новый день
            if (month==1){//если февраль
                int maxFebDays=28; //флаг високосности

                if ((year%4==0 & year%100!=0) | (year%400==0)){ //условие високосности
                    maxFebDays = 29;
                }

                if (day>maxFebDays){ //выход за границы февраля
                    day -= maxFebDays;
                    month+=1;
                }
            }
            else if (isFound(day31, month)){//если 31 день
                if (day>31){
                    day-=31;
                    month+=1;
                    if (month>11){
                        month-=12;
                        year+=1;
                    }

                }
            }
            else{//все остальные месяцы
                if (day>30){
                    day-=30;
                    month+=1;
                }
            }

        }//случая возвращения в прошлое
        else if (allMinutes<0){
            allMinutes = 24*60 + allMinutes;
            day-=1;
            if ((month-1)==1){//случай, если предыдущий месяц февраль
                int maxFebDays=28; //флаг високосности

                if ((year%4==0 & year%100!=0) | (year%400==0)){ //условие високосности
                    maxFebDays = 29;
                }

                if (day<=0){ //выход за границы февраля
                    day = maxFebDays;
                    month-=1;
                }
            }
            else if (isFound(day31, month-1)){//случай, если в предыдущем месяце 31 день
                if (day<=0){
                    day=31;
                    month-=1;
                    if (month<0){
                        month=11;
                        year-=1;
                    }


                }
            }
            else{//случай, если в предыдущем месяце 30 дней
                if (day<=0){
                    day=30;
                    month-=1;
                }
            }
        }
        return String.join("-", ""+year,""+(month+1), ""+day) + " " + formatTime((int) allMinutes/60, ((int) allMinutes)%60);
    }

    public static boolean isFound(int[] arr, int num){ //функция для проверки, есть ли элемент в массиве
        for (int i:arr){
            if (i==num){
                return true;
            }
        }
        return false;

    }

    public static String formatTime(int hour, int minutes){
        return String.join(":", hour<10?"0"+hour:""+hour, minutes<10?"0"+minutes:""+minutes);
    }


    public static boolean isNew(int num){
        ArrayList<Character> digits = new ArrayList<>();
        String tempNum = "" + num;
        String newNum = "";
        char tempDigit = tempNum.charAt(0);
        for (int i=0; i<tempNum.length(); i++){
            digits.add(tempNum.charAt(i));
            if (tempNum.charAt(i)!='0'){
                tempDigit = (char) Math.min(tempDigit, tempNum.charAt(i));
            }
        }
        newNum += tempDigit;
        digits.remove(Character.valueOf(tempDigit));
        for (int i=1; i<tempNum.length(); i++){
            tempDigit = digits.get(0);
            for (int j=1; j<digits.size(); j++){
                tempDigit = (char) Math.min(tempDigit, digits.get(j));
            }
            newNum+=tempDigit;
            digits.remove(Character.valueOf(tempDigit));
        }
        if (Integer.parseInt(newNum)<num){
            return false;
        }
        else{
            return true;
        }
    }

}