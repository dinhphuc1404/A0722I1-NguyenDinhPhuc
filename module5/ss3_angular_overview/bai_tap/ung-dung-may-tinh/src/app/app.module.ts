import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CaculatorComponent } from './component/caculator/caculator.component';
import { ColorComponent } from './component/color/color.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CaculatorComponent,
    ColorComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
