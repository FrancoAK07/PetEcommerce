import { Component, ElementRef, Renderer2, ViewChild } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ApiService } from "../services/api.service";
import { CartService } from "../services/cart.service";
import { Product } from "../models/product.model";
import { ActivatedRoute } from "@angular/router";
import { FormsModule } from "@angular/forms";

@Component({
	selector: "app-store",
	imports: [CommonModule, FormsModule],
	templateUrl: "./store.component.html",
	styleUrl: "./store.component.scss",
})
export class StoreComponent {
	@ViewChild("sidebar") sidebar!: ElementRef;
	@ViewChild("products") products!: ElementRef;
	@ViewChild("productCard") productCard!: ElementRef;
	sidebarVisible: boolean = false;
	currentProducts: any[] = [];
	searchTerm: string = "";
	isLoading: boolean = true;

	constructor(
		private renderer: Renderer2,
		private api: ApiService,
		private cartService: CartService,
		private route: ActivatedRoute
	) {}

	fetchData() {
		this.api.getAllProducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.isLoading = false;
				console.log("all products");
			},
			error: (e) => console.error(e),
		});
	}

	getCatProducts() {
		this.api.getCatProducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getDogProducts() {
		this.api.getDogProducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getFishProducts() {
		this.api.getFishproducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getBirdProducts() {
		this.api.getBirdproducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getProductsByType(type: string) {
		this.api.getProductsByType(type).subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	toggleSidebar(): void {
		this.sidebarVisible = !this.sidebarVisible;
		if (this.sidebarVisible) {
			this.renderer.removeClass(this.products.nativeElement, "is-11-desktop");
			this.renderer.addClass(this.products.nativeElement, "is-10-desktop");
			this.renderer.removeClass(this.sidebar.nativeElement, "is-1-desktop");
			this.renderer.addClass(this.sidebar.nativeElement, "is-2-desktop");
			this.renderer.removeClass(this.sidebar.nativeElement, "hidden");
		} else {
			this.renderer.removeClass(this.products.nativeElement, "is-10-desktop");
			this.renderer.addClass(this.products.nativeElement, "is-11-desktop");
			this.renderer.removeClass(this.sidebar.nativeElement, "is-2-desktop");
			this.renderer.addClass(this.sidebar.nativeElement, "is-1-desktop");
			this.renderer.addClass(this.sidebar.nativeElement, "hidden");
		}
	}

	addToCart(product: Product) {
		this.cartService.addProduct(product);
	}

	//filteredProducts acts as a variable and each time searchTerm changes it runs
	get filteredProducts() {
		if (!this.searchTerm) {
			return this.currentProducts;
		}

		return this.currentProducts.filter(
			(product) =>
				product.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
				product.description.toLowerCase().includes(this.searchTerm.toLowerCase())
		);
	}

	ngOnInit() {
		let productType;

		this.route.queryParamMap.subscribe((params) => {
			productType = params.get("productType");
		});

		if (productType) {
			switch (productType) {
				case "dog":
					this.getDogProducts();
					break;
				case "cat":
					this.getCatProducts();
					break;
				case "bird":
					this.getBirdProducts();
					break;
				case "fish":
					this.getFishProducts();
					break;
				case "toys":
					this.getProductsByType(productType);
					break;
				case "grooming":
					this.getProductsByType(productType);
					break;
				case "food":
					this.getProductsByType(productType);
					break;
			}
		} else {
			this.fetchData();
		}
	}
}
