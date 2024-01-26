import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/profile.model';
import { Topic } from 'src/app/models/topic.models';
import { ProfileService } from 'src/app/services/profile.service';
import { SessionService } from 'src/app/services/session.service';
import { TopicService } from 'src/app/services/topic.service';

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
    private profileService: ProfileService,
    private topicService: TopicService
  ) {}

  public onError = false;
  public profile!: Profile;
  public topics!: Topic[];
  public haveSubscription = false;
  public form!: FormGroup;

  public ngOnInit(): void {
    this.profileService.getProfile().subscribe((profile: Profile) => {
      this.profile = profile;
      this.initForm();
    });
    this.profileService.getAllTopicSubsribeAt().subscribe((topics: Topic[]) => {
      if (topics.length > 0) {
        this.haveSubscription = true;
      }
      this.topics = topics;
    });
  }

  public logout(): void {
    this.sessionService.logOut();
    this.router.navigate(['']);
  }
  private initForm(): void {
    this.form = this.formBuilder.group({
      email: [this.profile.email, [Validators.required, Validators.email]],
      username: [
        this.profile.username,
        [Validators.required, Validators.min(3)],
      ],
    });
  }

  public unsubscribeToTopic(topic: Topic) {
    this.topicService.unsubscribeToTopic(topic).subscribe({
      next: () => {
        this.reloadCurrentRoute();
      },
    });
  }

  public save() {
    const profile = this.form.value as Profile;
    this.profileService.save(profile).subscribe({
      next: () => {
        this.sessionService.logOut();
        this.reloadCurrentRoute();
      },
    });
  }

  private reloadCurrentRoute() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate([currentUrl]);
    });
  }
}
