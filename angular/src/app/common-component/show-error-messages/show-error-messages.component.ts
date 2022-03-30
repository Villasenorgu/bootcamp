import { Component, Input, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-show-error-messages',
  templateUrl: './show-error-messages.component.html',
  styleUrls: ['./show-error-messages.component.css']
})

export class ShowErrorMessagesComponent implements OnInit {

  @Input () errors : any;

  mensaje = '';
  hidden = false;

  constructor() { }

  ngOnInit(): void {
  }

  ngOnChanges( changes : SimpleChanges) : void{

    if (!this.errors) {
      this.hidden = true;
      return;
    }
    let msg = '';
    for (let err in this.errors) {
      switch (err) {
        case 'required':
          msg += 'Es obligatorio. ';
          break;
        case 'minlength':
          msg += `Debe tener al menos ${this.errors[err].requiredLength} caracteres. `;
          break;
        case 'maxlength':
          msg += `Debe tener como mucho ${this.errors[err].requiredLength} caracteres. `;
          break;
        case 'email':
          msg += 'El formato no es correcto. ';
          break;
        case 'min':
          msg += `El valor debe ser al menos un ${this.errors[err].min}. `;
          break;
        case 'max':
          msg += `El valor debe ser como mucho un ${this.errors[err].max}. `;
          break;
        default:
          if (typeof this.errors[err] === 'string')
            msg += `${this.errors[err]}${this.errors[err].endsWith('.')?'':'.'} `;
          else if (typeof this.errors[err]?.message === 'string')
            msg += `${this.errors[err].message}${this.errors[err].message.endsWith('.')?'':'.'} `;
          break;
      }
    }
    this.mensaje = msg.trim();
    this.hidden = this.mensaje === '';
  }



}
