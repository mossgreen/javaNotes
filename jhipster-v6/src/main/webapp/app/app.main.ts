import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { ProdConfig } from './blocks/config/prod.config';
import { Jhipsterv6AppModule } from './app.module';

ProdConfig();

if (module['hot']) {
  module['hot'].accept();
}

platformBrowserDynamic()
  .bootstrapModule(Jhipsterv6AppModule, { preserveWhitespaces: true })
  .then(success => console.log(`Application started`))
  .catch(err => console.error(err));
