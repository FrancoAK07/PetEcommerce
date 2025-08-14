import { Component } from "@angular/core";
import { CartService } from "../../core/services/cart.service";
import { Product } from "../../shared/models/product.model";
import { CommonModule } from "@angular/common";

@Component({
	selector: "app-cart",
	imports: [CommonModule],
	templateUrl: "./cart.component.html",
	styleUrl: "./cart.component.scss",
})
export class CartComponent {
	constructor(private cartService: CartService) {}

	totalPrice: number = 0;
	cartProducts: Product[] = [];
	totalItems: number = 0;

	addQty(productName: any) {
		const foundProduct = this.cartProducts.find((item) => item.name === productName);
		if (foundProduct) {
			foundProduct.qty++;
			this.totalPrice += foundProduct.price;
			this.cartService.updateCart(this.cartProducts);
		}
	}

	substractQty(productName: any) {
		const foundProduct = this.cartProducts.find((item) => item.name === productName);
		if (foundProduct) {
			foundProduct.qty--;
			this.totalPrice -= foundProduct.price;
			this.cartService.updateCart(this.cartProducts);
			if (foundProduct.qty === 0) {
				this.cartProducts = this.cartProducts.filter((item) => item.name !== productName);
				this.cartService.updateCart(this.cartProducts);
			}
		}
	}

	addTotal() {
		this.cartProducts.forEach((product: Product) => {
			const itemTotal = product.qty * product.price;
			this.totalPrice += itemTotal;
		});
	}

	ngOnInit() {
		this.cartProducts = this.cartService.getProducts();
		this.totalItems = this.cartProducts.length;
		this.addTotal();
	}
}
