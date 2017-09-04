package easytext.repository.api;

import easytext.domain.api.Text;

public interface TextRepository {
  Text findText(String id);
}
