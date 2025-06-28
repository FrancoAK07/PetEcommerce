import { Component, inject } from "@angular/core";
import { ApiService } from "../services/api.service";
import { AuthService } from "../services/auth.service";
import { User } from "../models/user.model";
import { FormsModule } from "@angular/forms";
import { Dialog } from "@angular/cdk/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
	selector: "app-login-form",
	imports: [FormsModule],
	templateUrl: "./login-form.component.html",
	styleUrl: "./login-form.component.scss",
})
export class LoginFormComponent {
	private dialog = inject(Dialog);
	constructor(private api: ApiService, private auth: AuthService, private snackBar: MatSnackBar) {}

	userEmail: string = "";
	userPassword: string = "";

	showSnackbar(message: string, snackBarClass: string) {
		this.snackBar.open(message, "Close", {
			duration: 2500,
			horizontalPosition: "center",
			verticalPosition: "top",
			panelClass: snackBarClass,
		});
	}

	submit() {
		if (!this.userEmail || !this.userPassword) {
			this.showSnackbar("All fields are required.", "warning-snackbar");
			return;
		}
		const user: User = {
			email: this.userEmail,
			password: this.userPassword,
		};

		this.api.logInUser(user).subscribe({
			next: (response) => {
				this.showSnackbar("Login successful!", "successful-snackbar");
				this.userEmail = "";
				this.userPassword = "";

				this.auth.login(response.name);
				this.dialog.closeAll();
			},
			error: (error) => {
				console.error("Error login user:", error);
				this.showSnackbar("Wrong email or password", "error-snackbar");
			},
		});
	}
}
