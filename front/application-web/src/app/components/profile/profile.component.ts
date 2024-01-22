import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/profile.model';
import { Topic } from 'src/app/models/topic.models';
import { ProfileService } from 'src/app/services/profile.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent {
  constructor(
    private router: Router,
    private sessionService: SessionService,
    private formBuilder: FormBuilder,
    private profileService: ProfileService
  ) {}

  public onError = false;
  public profile!: Profile;
  public topics!: Topic[];

  public ngOnInit(): void {
    this.profileService
      .getProfile()
      .subscribe(
        (profile: Profile) => (
          (this.profile = profile), console.log(this.profile)
        )
      );
    this.profileService
      .getAllTopicSubsribeAt()
      .subscribe((topics: Topic[]) => (this.topics = topics));
  }

  public logout(): void {
    this.sessionService.logOut();
    this.router.navigate(['']);
  }
  public form = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.min(3)]],
  });

  public unsubscribeToTopic(topic: Topic) {
    return null;
  }
}
