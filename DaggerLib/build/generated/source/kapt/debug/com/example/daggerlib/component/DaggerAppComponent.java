// Generated by Dagger (https://dagger.dev).
package com.example.daggerlib.component;

import android.content.Context;
import com.example.daggerlib.module.AppModule;
import com.example.daggerlib.module.AppModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private final DaggerAppComponent appComponent = this;

  private Provider<Context> provideContextProvider;

  private DaggerAppComponent(AppModule appModuleParam) {

    initialize(appModuleParam);

  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final AppModule appModuleParam) {
    this.provideContextProvider = DoubleCheck.provider(AppModule_ProvideContextFactory.create(appModuleParam));
  }

  @Override
  public Context context() {
    return provideContextProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public AppComponent build() {
      Preconditions.checkBuilderRequirement(appModule, AppModule.class);
      return new DaggerAppComponent(appModule);
    }
  }
}
