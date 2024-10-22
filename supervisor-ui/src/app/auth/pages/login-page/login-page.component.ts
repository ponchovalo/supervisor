import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { timeout } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {

  private fb = inject(FormBuilder);
  private authService = inject(AuthService);
  private messageService = inject(MessageService);
  private router = inject(Router)

  public myForm: FormGroup = this.fb.group({
    username: ['IValenzuela', [Validators.required]],
    password: ['12345678', [Validators.required]]
  })

  login(){
    const {username, password} = this.myForm.value;
    this.authService.login(username, password)
      .subscribe({
        next: () => {
          this.messageService.add({ severity: 'success', summary: `Bienvenido`, detail: `Login Correcto` }),
          setTimeout(() => {
            this.router.navigateByUrl('indicadores');
          }, 1500)

        },
        error: (error) => {
          this.messageService.add({ severity: 'error', summary: `${error.error}`, detail: `${error.businessExceptionDescription}` });
        }
      })
  }

}
