import { Component } from "@angular/core";
import { ApiService } from "../../core/services/api.service";
import { CommonModule } from "@angular/common";
import { Router } from "@angular/router";

@Component({
	selector: "app-home",
	imports: [CommonModule],
	templateUrl: "./home.component.html",
	styleUrl: "./home.component.scss",
})
export class HomeComponent {
	discountProducts: any[] = [];

	constructor(private api: ApiService, private router: Router) {}

	fetchData() {
		this.api.getDiscountProducts().subscribe({
			next: (response) => {
				this.discountProducts = response;
			},
			error: (e) => console.error(e),
		});
	}

	goToStore(productCategory: string) {
		this.router.navigate(["/store"], { queryParams: { productCategory } });
	}

	ngOnInit() {
		this.fetchData();
	}
}
