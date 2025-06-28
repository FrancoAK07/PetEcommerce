import { Component, ViewChild, Renderer2, ElementRef, inject } from "@angular/core";
import { RouterLink, RouterLinkActive, RouterOutlet } from "@angular/router";
import { CommonModule } from "@angular/common";
import { CartService } from "../services/cart.service";
import { Dialog } from "@angular/cdk/dialog";
import { LoginFormComponent } from "../login-form/login-form.component";
import { RegisterFormComponent } from "../register-form/register-form.component";
import { AuthService } from "../services/auth.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
	selector: "app-navbar",
	imports: [RouterLink, RouterLinkActive, CommonModule],
	templateUrl: "./navbar.component.html",
	styleUrl: "./navbar.component.scss",
})
export class NavbarComponent {
	@ViewChild("hamburgerBtn") hamburgerBtn!: ElementRef;
	@ViewChild("navbarMenu") navbarMenu!: ElementRef;
	@ViewChild("dogs") dogs!: ElementRef;
	@ViewChild("cats") cats!: ElementRef;
	@ViewChild("birds") birds!: ElementRef;
	private dialog = inject(Dialog);
	constructor(
		private renderer: Renderer2,
		private cartService: CartService,
		private auth: AuthService,
		private snackBar: MatSnackBar
	) {}

	numberOfItems: number = 0;
	userName: string | null = "";
	userLoggedIn: boolean = false;

	showSnackbar(message: string, snackBarClass: string) {
		this.snackBar.open(message, "Close", {
			duration: 2500,
			horizontalPosition: "center",
			verticalPosition: "top",
			panelClass: snackBarClass,
		});
	}

	toggleMobileMenu() {
		const hamburgerMenuActive = this.hamburgerBtn.nativeElement.classList;
		const navbarMenuActive = this.navbarMenu.nativeElement.classList;

		if (hamburgerMenuActive.contains("is-active") && navbarMenuActive.contains("is-active")) {
			this.hamburgerBtn.nativeElement.classList.remove("is-active");
			this.navbarMenu.nativeElement.classList.remove("is-active");
		} else {
			this.hamburgerBtn.nativeElement.classList.add("is-active");
			this.navbarMenu.nativeElement.classList.add("is-active");
		}
	}

	toggleDogs() {
		if (this.dogs.nativeElement.classList.contains("is-hidden-mobile")) {
			this.dogs.nativeElement.classList.remove("is-hidden-mobile");
		} else {
			this.dogs.nativeElement.classList.add("is-hidden-mobile");
		}
	}

	toggleCats() {
		if (this.cats.nativeElement.classList.contains("is-hidden-mobile")) {
			this.cats.nativeElement.classList.remove("is-hidden-mobile");
		} else {
			this.cats.nativeElement.classList.add("is-hidden-mobile");
		}
	}

	protected openLoginModal() {
		this.dialog.open(LoginFormComponent);
	}

	protected openRegisterModal() {
		this.dialog.open(RegisterFormComponent);
	}

	logOut() {
		this.auth.logOut();
		this.showSnackbar("See you soon!", "successful-snackbar");
	}

	capitalizeFirstLetter(str: string | null) {
		if (!str) return str;
		return str.charAt(0).toUpperCase() + str.slice(1);
	}

	ngOnInit() {
		this.cartService.checkProducts();

		this.cartService.numberOfItems$.subscribe((products) => {
			this.numberOfItems = products.length;
			console.log(products);
		});

		this.auth.loggedIn$.subscribe((loggedIn) => {
			this.userLoggedIn = loggedIn;
		});

		this.auth.userName$.subscribe((userName) => {
			this.userName = userName;
		});
	}
}
