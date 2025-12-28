public class Main {


    public static void main(String[] args) {
        SharedResourceCAS resource = new SharedResourceCAS(10);
        SharedResourceUnsafe unsafeResource = new SharedResourceUnsafe(10);
        SharedResourceSync syncResource = new SharedResourceSync(10);

        Thread th1 = new Thread(()->{
            for(int i=0; i<200; i++){
                resource.increment();
                unsafeResource.increment();
                syncResource.increment();
                try {
                    Thread.sleep(10);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread th2 = new Thread(()->{
            for(int i=0; i<200; i++){
                resource.increment();
                unsafeResource.increment();
                syncResource.increment();
                try {
                    Thread.sleep(10);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();

            System.out.println("Result from CAS based increments: "+resource.get());
            System.out.println("Result from synchronized method increments: "+syncResource.get());
            System.out.println("Result from thread-unsafe increments: "+unsafeResource.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
