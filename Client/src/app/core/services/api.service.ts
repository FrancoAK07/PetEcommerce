import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { HttpParams } from "@angular/common/http";
import { User } from "../../shared/models/user.model";
import { environment } from "../../../environments/environment";

@Injectable({
	providedIn: "root",
})
export class ApiService {
	constructor(private http: HttpClient) {}

	getDogProducts(): Observable<any> {
		return this.http.get(`${environment.apiUrl}/dogproducts`);
	}

	getCatProducts(): Observable<any> {
		return this.http.get(`${environment.apiUrl}/catproducts`);
	}

	getFishproducts(): Observable<any> {
		return this.http.get(`${environment.apiUrl}/fishproducts`);
	}

	getBirdproducts(): Observable<any> {
		return this.http.get(`${environment.apiUrl}/birdproducts`);
	}

	getDiscountProducts(): Observable<any> {
		return this.http.get(`${environment.apiUrl}/products/discounts`);
	}

	getProductsByCategory(category: string): Observable<any> {
		const params = new HttpParams().set("category", category);
		return this.http.get(`${environment.apiUrl}/products/category`, { params });
	}

	getAllProducts(): Observable<any> {
		return this.http.get(`${environment.apiUrl}/products`);
	}

	createUser(user: User): Observable<any> {
		return this.http.post(`${environment.apiUrl}/users`, user);
	}

	getAllUsers(): Observable<any> {
		return this.http.get(`${environment.apiUrl}/users`);
	}

	logInUser(user: User): Observable<any> {
		return this.http.post(`${environment.apiUrl}/users/login`, user);
	}
}
