import { Component, ElementRef, Renderer2, ViewChild } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ApiService } from "../../core/services/api.service";
import { CartService } from "../../core/services/cart.service";
import { Product } from "../../shared/models/product.model";
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
	currentProducts: Product[] = [];
	filteredProducts: Product[] = [];
	searchTerm: string = "";
	isLoading: boolean = true;

	constructor(
		private renderer: Renderer2,
		private api: ApiService,
		private cartService: CartService,
		private route: ActivatedRoute
	) {}

	getAllProducts() {
		this.isLoading = true;
		this.api.getAllProducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.filteredProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getCatProducts() {
		this.isLoading = true;
		this.api.getCatProducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.filteredProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getDogProducts() {
		this.isLoading = true;
		this.api.getDogProducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.filteredProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getFishProducts() {
		this.isLoading = true;
		this.api.getFishproducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.filteredProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getBirdProducts() {
		this.isLoading = true;
		this.api.getBirdproducts().subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.filteredProducts = response;
				this.isLoading = false;
			},
			error: (e) => console.error(e),
		});
	}

	getProductsByCategory(category: string) {
		this.isLoading = true;
		this.api.getProductsByCategory(category).subscribe({
			next: (response) => {
				this.currentProducts = response;
				this.filteredProducts = response;
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

	filterProducts() {
		this.filteredProducts = [...this.currentProducts];
		if (this.searchTerm) {
			this.filteredProducts = this.currentProducts.filter(
				(product) =>
					product.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
					product.description.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
					product.category?.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
					product.petType?.toLowerCase().includes(this.searchTerm.toLowerCase())
			);
		}
	}

	ngOnInit() {
		let productCategory;

		this.route.queryParamMap.subscribe((params) => {
			productCategory = params.get("productCategory");
		});

		if (productCategory) {
			switch (productCategory) {
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
					this.getProductsByCategory(productCategory);
					break;
				case "grooming":
					this.getProductsByCategory(productCategory);
					break;
				case "food":
					this.getProductsByCategory(productCategory);
					break;
			}
		} else {
			this.getAllProducts();
		}
	}
}
