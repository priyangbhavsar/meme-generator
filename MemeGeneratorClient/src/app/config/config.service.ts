import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Config } from '../models/configModel';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  configUrl = 'assets/config.json';
  constructor(private http: HttpClient) { }
  config: Config | undefined

  async getConfig(): Promise<Config | undefined> {
    if (this.config) {
      return this.config;
    }
    await this.http.get<Config>(this.configUrl).toPromise().then((data: Config) => this.config = { ...data });
    return this.config;
  }
}
