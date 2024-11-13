import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { MessagesModule } from 'primeng/messages';
import { DividerModule } from 'primeng/divider';
import { TableModule } from 'primeng/table';
import { DialogModule } from 'primeng/dialog';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { ProgressBarModule } from 'primeng/progressbar';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    ToastModule,
    MessagesModule,
    DividerModule,
    TableModule,
    DialogModule,
    CalendarModule,
    DropdownModule,
    ProgressBarModule
  ],
  exports: [
    CardModule,
    ButtonModule,
    InputTextModule,
    ToastModule,
    MessagesModule,
    DividerModule,
    TableModule,
    DialogModule,
    CalendarModule,
    DropdownModule,
    ProgressBarModule
  ]
})
export class PrimengModule { }
