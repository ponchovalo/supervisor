import { Component, computed, inject, OnInit } from '@angular/core';
import { AuthService } from '../../../auth/services/auth.service';
import { User } from '../../../auth/interfaces/user.interface';

@Component({
  selector: 'app-indica-layout',
  templateUrl: './indica-layout.component.html',
  styleUrl: './indica-layout.component.css'
})
export class IndicaLayoutComponent {


  private AuthService = inject(AuthService);

  //public user = computed(()=> this.AuthService.currentUser());

  get user() {
    return this.AuthService.currentUser();
  }









}
