package selected_labs.repository;

import java.util.List;
import java.util.Optional;

/**
 * Generic repository interface for data access operations
 * @param <T> The entity type
 * @param <ID> The type of the entity's identifier
 */
public interface Repository<T, ID> {
    /**
     * Find an entity by its ID
     * @param id The entity identifier
     * @return Optional containing the entity if found
     */
    Optional<T> findById(ID id);

    /**
     * Retrieve all entities
     * @return List of all entities
     */
    List<T> findAll();

    /**
     * Save or update an entity
     * @param entity The entity to save
     * @return The saved entity
     */
    T save(T entity);

    /**
     * Delete an entity by its ID
     * @param id The entity identifier
     */
    void delete(ID id);

    /**
     * Check if an entity exists
     * @param id The entity identifier
     * @return true if entity exists, false otherwise
     */
    boolean exists(ID id);
}
