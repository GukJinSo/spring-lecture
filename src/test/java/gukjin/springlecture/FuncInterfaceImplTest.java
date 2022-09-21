package gukjin.springlecture;

import org.junit.jupiter.api.Test;

@FunctionalInterface
interface FuncInterface {
    void start();
}


class FuncInterfaceImplTest {

    @Test
    void test() {

        // 익명 클래스
        new FuncInterface(){
            @Override
            public void start(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("익명 클래스 "+i);
                }
            };
        }.start();


        // 람다
        FuncInterface t = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("익명 클래스 "+i);
            };
        };
        t.start();
    }
}