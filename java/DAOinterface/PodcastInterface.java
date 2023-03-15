package DAOinterface;

import Model.Podcast;

import java.util.List;

public interface PodcastInterface {
    List<Podcast> display_allpodcast();
    List<Podcast> sort_podcasts();

    Podcast search_podcasts(int podcast_id);

    void Play_podcast();
}
