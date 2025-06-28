import { Routes } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { StoreComponent } from "./store/store.component";
import { CartComponent } from "./cart/cart.component";

export const routes: Routes = [
	{ path: "", component: HomeComponent },
	{ path: "store", component: StoreComponent },
	{ path: "cart", component: CartComponent },
];
