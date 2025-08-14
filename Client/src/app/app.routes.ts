import { Routes } from "@angular/router";
import { HomeComponent } from "./features/home/home.component";
import { StoreComponent } from "./features/store/store.component";
import { CartComponent } from "./features/cart/cart.component";

export const routes: Routes = [
	{ path: "", component: HomeComponent },
	{ path: "store", component: StoreComponent },
	{ path: "cart", component: CartComponent },
];
