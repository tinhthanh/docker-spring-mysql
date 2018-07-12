import { cacheStorage } from './cacheStorage';
import { RequestCacheService } from './requestCache.service';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpEvent, HttpResponse, HTTP_INTERCEPTORS } from '@angular/common/http';
import {
    HttpRequest,
    HttpHandler,
    HttpInterceptor
} from '@angular/common/http';
import { tap } from 'rxjs/operators';

const TTL = cacheStorage.cache.time;

@Injectable()
export class CacheInterceptor implements HttpInterceptor {
    constructor(private cache: RequestCacheService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        if ( req.method === 'GET') {
            const cachedResponse = this.cache.get(req.url);
            return cachedResponse
                ? Observable.of(cachedResponse)
                : this.sendRequest(req, next);
        } else {
         return next.handle(req);
        }
    }

    sendRequest(
        req: HttpRequest<any>,
        next: HttpHandler
    ): Observable<HttpEvent<any>> {
        return next.handle(req).pipe(
          tap( event => {
            if (event instanceof HttpResponse) {
                this.cache.set(req.url, event, TTL);
            }
            })
    );
    }
}
export let  CacheConfig = {
    provide: HTTP_INTERCEPTORS,
    useClass: CacheInterceptor,
    multi: true
  };
