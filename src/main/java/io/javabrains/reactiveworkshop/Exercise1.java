package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        int i = 1;
        // Print all numbers in the intNumbersStream stream
        System.out.println("Exercise Number: " + i++);
        StreamSources.intNumbersStream().forEach((n) -> System.out.print(n + " "));
        System.out.println();
        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Exercise Number: " + i++);
        StreamSources.intNumbersStream().filter(n -> n > 5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Exercise Number: " + i++);
        StreamSources.intNumbersStream().filter(n -> n > 5).skip(1).limit(2).forEach(n -> System.out.print(n + " "));
        System.out.println();
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Exercise Number: " + i++);
        Integer value = StreamSources.intNumbersStream().filter(n -> n > 5).findFirst().orElse(-1);
        System.out.print(value + " ");
        // Print first names of all users in userStream
        System.out.println("Exercise Number: " + i++);
        StreamSources.userStream().forEach(n -> System.out.println(n.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Exercise Number: " + i++);
        Stream<Integer> intNumbers = StreamSources.intNumbersStream();
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(num -> num.getId().equals(id)))
                .forEach(user -> System.out.println(user.getFirstName()));
    }

}
