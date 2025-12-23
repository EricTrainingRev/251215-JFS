import { Directive, OnDestroy } from "@angular/core";
import { Subscription } from "rxjs";

/*
    The Directive decorator here simply tells Angular that this is a resource that it needs
    to manage. Specifically, this resource implements the ngOnDestroy method, so Angular needs
    to actually run it when any component that inherits this class is destroyed
*/
@Directive()
export abstract class Subscriber implements OnDestroy {

    /*
        You can put a question mark at the end of a variable name to tell the TS compiler that
        the resource will be initialized somewhere else in your code. For our purposes, we will
        need to initialize it in the inheriting child classes
    */
    private subscription?: Subscription

    ngOnDestroy(): void {
        /*
            If you use a ? as part of a variable declaration, you need to make sure that you
            also use it later on in your code. When a question mark is used as part of a variable
            reference you are telling the TS compiler you know the variable might be undefined, but
            you have an action you want to try and perform anyways.

            The type-safe way to unsubscribe in this case is to check the variable is an instance 
            of Subscription, then call unsubscribe
        */
        // this.subscription?.unsubscribe();
        if(this.subscription instanceof Subscription){
            this.subscription.unsubscribe();
        }
    }
}
