import { Component, Injectable } from "@angular/core";
import { RouterOutlet } from "@angular/router";
import { NavbarComponent } from "./navbar/navbar.component";
import { FooterComponent } from "./footer/footer.component";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { FormsModule } from "@angular/forms";

@Component({
	selector: "app-root",
	imports: [RouterOutlet, NavbarComponent, FooterComponent, MatSnackBarModule, FormsModule],
	templateUrl: "./app.component.html",
	styleUrl: "./app.component.scss",
})
@Injectable({
	providedIn: "root",
})
export class AppComponent {
	title = "Angular_Java";
	name: string = "franco";
}
