package executorsFactory;

import java.util.concurrent.RecursiveTask;

public class ComputeRecursiveTask extends RecursiveTask<Integer> {

    int n;

    ComputeRecursiveTask(int n){
        this.n = n;
    }

    @Override
    protected Integer compute() {

        if(n == 0 || n== 1) {
            return 0;
        }
        else if(n == 2){
            return 1;
        }else{
            ComputeRecursiveTask first = new ComputeRecursiveTask(n-2);
            ComputeRecursiveTask second = new ComputeRecursiveTask(n-1);

            // fork tasks for parallel execution
            first.fork();
            second.fork();

            // wait for finish and join
            int firstResult = first.join();
            int secondResult = second.join();

            // combine and return
            return firstResult+secondResult;
        }
    }
}
