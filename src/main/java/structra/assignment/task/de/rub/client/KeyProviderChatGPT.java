package structra.assignment.task.de.rub.client;

import structra.assignment.framework.llm.KeyProvider;

public class KeyProviderChatGPT implements KeyProvider{
  private String KEY = "structra-1343abnc-dGhpcyBpcyBub3Qgb3VyIGFwaSBrZXksIG5pY2UgdHJ5IHRobyA6KQ==";

  public String getApiKey(){
    return this.KEY;
  }
}
