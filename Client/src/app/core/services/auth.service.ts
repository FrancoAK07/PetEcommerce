import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
	providedIn: "root",
})
export class AuthService {
	private loggedIn = new BehaviorSubject<boolean>(false);
	loggedIn$ = this.loggedIn.asObservable();
	private userName = new BehaviorSubject<string | null>(null);
	userName$ = this.userName.asObservable();

	constructor() {}

	login(userName: string) {
		this.loggedIn.next(true);
		this.userName.next(userName);
	}

	logOut() {
		this.loggedIn.next(false);
		this.userName.next(null);
	}
}
