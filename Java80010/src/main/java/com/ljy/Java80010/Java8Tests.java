package com.ljy.Java80010;

import java.awt.print.Book;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Tests {

    private static void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    private static void sortUsingJava8(List<String> names){
        Collections.sort(names,(s1,s2)->s1.compareTo(s2));
    }

    private static interface MathOperation{
        int operation(int a,int b);
    }
    private static interface GreetingService{
        void sayMessage(String message);
    }
    private static int operate(int a,int b,MathOperation operation){
        return operation.operation(a,b);
    }


    private static void eval(List<Integer> list, Predicate<Integer> predicate){
        for (Integer t:list){
            if(predicate.test(t)){
                System.out.println(t+" ");
            }
        }
    }

    private static int compute(int a, Function<Integer,Integer> function){
        return  function.apply(a);
    }
    private static String str(int a,Function<Integer,String> function){
        return function.apply(a);
    }

    private static <T> Predicate<T>  testCustomerF(CustomerF<? super T,?> customerF){
       return t->"aa".equals(customerF.apply(t));
    }
    public static void main(String[] args){
        // region lambda
//        List<String> names=new ArrayList<>();
//        names.add("aa");
//        names.add("cc");
//        names.add("dd");
//        names.add("bb");
//
//        List<String> names2=new ArrayList<>();
//        names2.add("aa");
//        names2.add("cc");
//        names2.add("dd");
//        names2.add("bb");
//
//
//        System.out.println("Sort using Java 7 syntax:");
//        sortUsingJava7(names);
//        System.out.println(names);
//
//        System.out.println("Sort using Java 8 syntax:");
//        sortUsingJava8(names2);
//        System.out.println(names2);
//
//        MathOperation addition=(a,b)->a+b;
//        MathOperation subtraction=(a,b)->a-b;
//        MathOperation multiplication=(a,b)->{return a*b;};
//        MathOperation division=(a,b)->a/b;
//
//        System.out.println("10+5="+operate(10,5,addition));
//        System.out.println("10-5="+operate(10,5,subtraction));
//        System.out.println("10*5="+operate(10,5,multiplication));
//        System.out.println("10/5="+operate(10,5,division));
//
//        GreetingService greetingService1=message -> System.out.println("Hello "+message);
//        GreetingService greetingService=(message)->System.out.println("Hello "+message);
//        greetingService.sayMessage("World");
//        greetingService.sayMessage("Java");
        //endregion

        //region 方法引用有助于自己的名字指向方法。方法参考描述使用“::”符号
//        List<String> names=new ArrayList<>();
//        names.add("aa");
//        names.add("bb");
//        names.add("cc");
//        names.add("dd");
//
//        names.forEach(System.out::println);

        //endregion

        //region 函数式接口

//        Map<String,String> t=new HashMap<>();
//        String value="";
//        value=t.get("11");
//        if(value==null){
//            value=t.put("11","aa");
//        }
//        System.out.println(value);
//        System.out.println(t.get("11"));

//        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        System.out.println("print all numbers:");
//        eval(list,t->true);
//
//        System.out.println("print even numbers:");
//        eval(list,t->t%2==0);
//
//        System.out.println("print numbers greater then 3:");
//        eval(list,t->t>3);
//
//        System.out.println(compute(2,i->i+2));
//        System.out.println(str(2,i->"Hello "+i));


        //endreigon

        //默认方法 defalut

        //region 方法引用+函数式接口
        List<CustomerInfo> customerInfos=new ArrayList<>();
        customerInfos.add(new CustomerInfo(10,"aa"));
        customerInfos.add(new CustomerInfo(15,"bb"));
        customerInfos.add(new CustomerInfo(20,"cc"));

        System.out.println(customerInfos.stream().filter(testCustomerF(CustomerInfo::getName)).count());
        //endregion


        //region options
//        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7);
//        Optional<Integer> optionalInteger=list.stream().filter(t->t.intValue()==9).findFirst();
//        if(optionalInteger.isPresent()){
//            System.out.println(optionalInteger.get());
//        }optionalInteger=list.stream().filter(t->t.intValue()==6).findFirst();
//        if(optionalInteger.isPresent()){
//            System.out.println(optionalInteger.get());
//        }
        //endregion

        //region LocalTime

//        LocalDateTime localDateTime=LocalDateTime.now();
//        System.out.println("Current datetime:"+localDateTime);
//
//        LocalDate localDate=localDateTime.toLocalDate();
//        System.out.println("Current date:"+localDate);
//        Month month=localDateTime.getMonth();
//        int day=localDateTime.getDayOfMonth();
//        int seconds=localDateTime.getSecond();
//        System.out.println("Month :"+month+",Day :"+day+",Seconds:"+seconds);
//
//        LocalDateTime dateTime2=localDateTime.withDayOfMonth(10).withYear(2018);
//        System.out.println("dateTime2:"+dateTime2);
//
//        LocalDate date2=LocalDate.of(2018,Month.DECEMBER,12);
//        System.out.println("date2:"+date2);
//
//        LocalTime localTime=LocalTime.of(22,15);
//        System.out.println("localTime:"+localTime);
//
//        LocalTime localTime1=LocalTime.parse("22:16:12");
//        System.out.println("localTime:"+localTime1);
        //endregion

        //region  ZoneDateTime
//        ZonedDateTime zonedDateTime=ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
//        System.out.println("zoneDateTime:"+zonedDateTime);
//
//        ZoneId zoneId=ZoneId.of("Europe/Paris");
//        System.out.println("ZoneID:"+zoneId);
//        ZoneId currentZone=ZoneId.systemDefault();
//        System.out.println("Current ZoneID:"+currentZone);
        //endregion

        // region ChronoUnit
//        LocalDate today=LocalDate.now();
//        System.out.println("Local Date:"+today);
//
//        LocalDate nextWeek=today.plus(1,ChronoUnit.WEEKS);
//        System.out.println("next Week:"+nextWeek);
//
//        LocalDate nextMonth=today.plus(1,ChronoUnit.MONTHS);
//        System.out.println("next Month:"+nextMonth);
//
//        LocalDate nextYear=today.plus(1,ChronoUnit.YEARS);
//        System.out.println("next Year:"+nextYear);
//
//        LocalDate nextDecade=today.plus(1,ChronoUnit.DECADES);
//        System.out.println("Date after ten year:"+nextDecade);
        //endregion

        // region Period & Duration
//        LocalDate dateNow=LocalDate.now();
//        System.out.println("Current Date:"+dateNow);
//
//        LocalDate nextMonth=dateNow.plus(1,ChronoUnit.MONTHS);
//        System.out.println("Next Month:"+nextMonth);
//
//        Period period=Period.between(dateNow,nextMonth);
//        System.out.println("Period:"+period);
//
//
//        LocalTime localTime=LocalTime.now();
//        System.out.println("Current Time:"+localTime);
//        LocalTime nextHours=localTime.plus(1,ChronoUnit.HOURS);
//        System.out.println("Next Hours:"+nextHours);
//        Duration duration=Duration.between(nextHours,localTime);
//        System.out.println("Duration:"+duration);
        //endregion

        //region TemporalAdjuster
//        LocalDate localDate=LocalDate.now();
//        System.out.println("Current date:"+localDate);
//
//        LocalDate nextDate=localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//        System.out.println("next friday:"+nextDate);
        //endregion


    }
}
