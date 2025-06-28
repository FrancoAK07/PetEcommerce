import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { HttpParams } from "@angular/common/http";
import { User } from "../models/user.model";

@Injectable({
	providedIn: "root",
})
export class ApiService {
	constructor(private http: HttpClient) {}

	getDogProducts(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/dogproducts");
	}

	getCatProducts(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/catentities");
	}

	getFishproducts(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/fishentities");
	}

	getBirdproducts(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/birdentities");
	}

	getDiscountProducts(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/dogproducts/discounts");
	}

	getDogFood(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/dogproducts/dogfood");
	}

	getDogGrooming(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/dogproducts/doggrooming");
	}

	getProductsByType(type: string): Observable<any> {
		const params = new HttpParams().set("type", type);
		return this.http.get("https://petecommerce-java-server.onrender.com/api/products/byType", { params });
	}

	getAllProducts(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/products");
	}

	createUser(user: User): Observable<any> {
		return this.http.post("https://petecommerce-java-server.onrender.com/api/users", user);
	}

	getAllUsers(): Observable<any> {
		return this.http.get("https://petecommerce-java-server.onrender.com/api/users");
	}

	logInUser(user: User): Observable<any> {
		return this.http.post("https://petecommerce-java-server.onrender.com/api/users/login", user);
	}
}
