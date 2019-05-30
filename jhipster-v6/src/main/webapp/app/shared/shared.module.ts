import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Jhipsterv6SharedLibsModule, Jhipsterv6SharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [Jhipsterv6SharedLibsModule, Jhipsterv6SharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [Jhipsterv6SharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Jhipsterv6SharedModule {
  static forRoot() {
    return {
      ngModule: Jhipsterv6SharedModule
    };
  }
}
