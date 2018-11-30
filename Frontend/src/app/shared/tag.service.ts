import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Tag} from '../model/Tag';
import {Subject} from 'rxjs/Subject';
import {ProjectGeneral} from '../model/ProjectGeneral';

@Injectable()
export class TagService {
  constructor(private httpClient: HttpClient) {}

  public tagSubject = new Subject<Tag[]>();
  private tagEndpoint = 'http://localhost:8080/tags';

  public getAllTags() {
    this.httpClient.get(this.tagEndpoint)
      .subscribe((data: Tag[]) => {
        this.tagSubject.next(data);
      });
  }
}
