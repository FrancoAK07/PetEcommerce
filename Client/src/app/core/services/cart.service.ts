import { Injectable } from "@angular/core";
import { Product } from "../../shared/models/product.model";
import { BehaviorSubject } from "rxjs";

@Injectable({
	providedIn: "root",
})
export class CartService {
	constructor() {}

	private products = new BehaviorSubject<Product[]>([]);
	numberOfItems$ = this.products.asObservable();

	addProduct(product: Product) {
		const currentProducts = this.products.value;
		const foundProduct = currentProducts.find((item) => item.name === product.name);

		if (foundProduct) {
			foundProduct.qty++;
		} else {
			product.qty = 1;
			this.products.value.push(product);
		}

		this.products.next([...currentProducts]);
		sessionStorage.setItem("cart", JSON.stringify(this.products.value));
	}

	getProducts() {
		const savedProductsString = sessionStorage.getItem("cart");
		if (savedProductsString) {
			const savedProducts = JSON.parse(savedProductsString);
			this.products.next([...savedProducts]);
		}
		return this.products.value;
	}

	updateCart(cartProducts: any) {
		this.products.next([...cartProducts]);
		sessionStorage.setItem("cart", JSON.stringify(cartProducts));
	}

	checkProducts() {
		const savedProductsString = sessionStorage.getItem("cart");
		if (savedProductsString) {
			const savedProducts = JSON.parse(savedProductsString);
			this.products.next([...savedProducts]);
		}
	}
}
