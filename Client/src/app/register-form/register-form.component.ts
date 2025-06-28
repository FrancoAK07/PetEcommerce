import { Component } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { User } from "../models/user.model";
import { ApiService } from "../services/api.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
	selector: "app-register-form",
	imports: [FormsModule],
	templateUrl: "./register-form.component.html",
	styleUrl: "./register-form.component.scss",
})
export class RegisterFormComponent {
	userName: string = "";
	userEmail: string = "";
	userPassword: string = "";

	constructor(private api: ApiService, private snackBar: MatSnackBar) {}

	showSnackbar(message: string, snackBarClass: string) {
		this.snackBar.open(message, "Close", {
			duration: 2500,
			horizontalPosition: "center",
			verticalPosition: "top",
			panelClass: snackBarClass,
		});
	}

	submit() {
		if (!this.userName || !this.userEmail || !this.userPassword) {
			console.error("All fields are required.");
			this.showSnackbar("All fields are required.", "warning-snackbar");
			return;
		}
		const user: User = {
			name: this.userName,
			email: this.userEmail,
			password: this.userPassword,
		};

		this.api.createUser(user).subscribe({
			next: (response) => {
				this.showSnackbar("Signed up successfuly!", "successful-snackbar");
				this.userName = "";
				this.userEmail = "";
				this.userPassword = "";
			},
			error: (error) => {
				console.error("Error creating user:", error);
				this.showSnackbar("Something went wrong!", "error-snackbar");
			},
		});
	}
}
