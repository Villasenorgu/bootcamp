import { Component, OnInit } from '@angular/core';
import { CalculadoraComponent } from '../calculadora/calculadora.component';
import { ContactosComponent } from '../contactos/componente.component';
import { DemosComponent } from '../demos/demos.component';
import { FormularioComponent } from '../formulario/formulario.component';
import { HomeComponent } from '../main/home/home.component';

@Component({
  selector: 'app-dinamico',
  templateUrl: './dinamico.component.html',
  styleUrls: ['./dinamico.component.css']
})
export class DinamicoComponent implements OnInit {
  menu = [
    {texto: 'Contactos', icono: 'fa-solid fa-user', componente: ContactosComponent},
    {texto: 'Formulario', icono: 'fa-solid fa-pencil', componente:FormularioComponent},
    {texto: 'Calculadora', icono: 'fa-solid fa-calculator', componente:CalculadoraComponent},
    {texto: 'Inicio', icono: 'fa-solid fa-house', componente:HomeComponent},
    {texto: 'Demos', icono: 'fa-solid fa-chalkboard-user', componente:DemosComponent},
  ]
  actual = this.menu[0].componente
  constructor() { }

  ngOnInit(): void {
  }
  seleccionar(indice:number):void{
    this.actual = this.menu[indice].componente
  }
}
