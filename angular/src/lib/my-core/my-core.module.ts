import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SizerComponent } from './components/sizer.component';
import { CapitalizePipe, ElipsisPipe, PIPES_CADENAS } from './pipes/cadenas.pipe';
import { MIS_VALIDADORES } from './directives/validadores/mis-validaciones.directive';




@NgModule({
  declarations: [SizerComponent,PIPES_CADENAS, MIS_VALIDADORES,],
  exports : [SizerComponent,PIPES_CADENAS, MIS_VALIDADORES, ],
  imports: [
    CommonModule
  ]
})
export class MyCoreModule { }
