import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormButtonsComponent } from './form-buttons/form-buttons.component';
import { ShowErrorMessagesComponent } from './show-error-messages/show-error-messages.component';



@NgModule({
  declarations: [
     FormButtonsComponent, ShowErrorMessagesComponent,
  ],
  exports: [
     FormButtonsComponent, ShowErrorMessagesComponent,
  ],
  imports: [
    CommonModule
  ]
})
export class CommonComponentModule { }
