import com.A;

/**
 * Created by x930073498 on 17-4-27.
 */

public class Test {
    public static void main(String... arg0) {
        new A().print().invoke();
        new A().printA();//        Observable.create((ObservableOnSubscribe<Integer>) observer -> {
//            try {
//                if (!observer.isDisposed()) {
//                    for (int i = 0; i < 5; i++) {
//                        observer.onNext(i);
//                    }
//                    observer.onComplete();
//
//                }
//            } catch (Exception e) {
//                observer.onError(e);
//            }
//        }).subscribe(System.out::println, e -> System.out.println("this is onError"), () -> System.out.println("onComplete"));
//
//        Observable.defer(() -> new Observable<Integer>() {
//
//            @Override
//            protected void subscribeActual(Observer<? super Integer> observer) {
//                try {
//                    for (int i = 0; i < 5; i++) {
//                        observer.onNext(i);
//                    }
//                    observer.onComplete();
//                } catch (Exception e) {
//                    observer.onError(e);
//                }
//            }
//        }).subscribe(System.out::println, e -> System.out.println("this is onError"), () -> System.out.println("onComplete"));

//        Integer[] items = {0, 1, 2, 3, 4, 5};
//        Observable.fromArray(items).subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.print("onComplete"));
//        Observable.timer(2, TimeUnit.SECONDS).subscribe(System.out::println);
//        Observable.just(items,items,items).blockingIterable().forEach((integers) -> Observable.fromArray(integers).subscribe(System.out::println));
//        Observable.just(items, items, items).blockingSubscribe(integers -> Flowable.fromArray(integers).subscribe(System.out::println));
    }
}
